package com.app.isanpablo.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.app.isanpablo.data.LoginRepository
import com.app.isanpablo.data.Result

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.awaitResponse

import com.app.isanpablo.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    // It will show a toast message to the screen when the login fails or when the user is logged in.
    fun login(username: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.login(username, password).awaitResponse()
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    loginResponse?.let {
                        _loginResult.postValue(LoginResult(success = LoggedInUserView(displayName = it.username)))
                    } ?: run {
                        _loginResult.postValue(LoginResult(error = R.string.login_failed))
                    }
                } else {
                    _loginResult.postValue(LoginResult(error = R.string.login_failed))
                }
            } catch (e: HttpException) {
                _loginResult.postValue(LoginResult(error = R.string.login_failed))
            } catch (e: Exception) {
                _loginResult.postValue(LoginResult(error = R.string.login_failed))
            }
        }
    }

    // It will check if the username and password are valid.
    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 2
    }
}