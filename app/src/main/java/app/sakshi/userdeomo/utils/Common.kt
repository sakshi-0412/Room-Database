package app.sakshi.userdeomo.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.view.inputmethod.InputMethodManager
import java.util.regex.Matcher
import java.util.regex.Pattern


object Common {
    val BASE_URL = "http://collectpcts.mypiggycoins.com/api/"

    fun hideSoftKeyboard(foActivity: Activity) {
        val inputMethodManager = foActivity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        if (foActivity.currentFocus != null) inputMethodManager.hideSoftInputFromWindow(foActivity.currentFocus!!.windowToken, 0)
    }

    fun showSoftKeyboard(foActivity: Activity) {
        val inputMethodManager = foActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun isInternetAvailable(foContext: Context?): Boolean {
        if (foContext == null) return false
        val loConnectivityManager = foContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (loConnectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val loCapabilities = loConnectivityManager.getNetworkCapabilities(loConnectivityManager.activeNetwork)
                if (loCapabilities != null) {
                    if (loCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return true
                    } else if (loCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        return true
                    } else if (loCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        return true
                    }
                }
            } else {
                try {
                    val loActiveNetworkInfo = loConnectivityManager.activeNetworkInfo
                    if (loActiveNetworkInfo != null && loActiveNetworkInfo.isConnected) {
                        return true
                    }
                } catch (e: java.lang.Exception) {
                }
            }
        }
        return false
    }

    fun getHeaderMap(foContext: Context): Map<String, String> {
        val headerMap = mutableMapOf<String, String>()
        headerMap[Constants.HeaderValues.ACCESS_TOKEN] = "60096e68367188eaf3ad72f405d0f93f"
        Log.i("Headers", headerMap.toString())

        return headerMap
    }

    fun isEmailValid(fsEmail: String?): Boolean {
        val lsExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val loPattern: Pattern = Pattern.compile(lsExpression, Pattern.CASE_INSENSITIVE)
        val loMatcher: Matcher = loPattern.matcher(fsEmail)
        return loMatcher.matches()
    }

   /* fun isEmailValid(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }*/


}