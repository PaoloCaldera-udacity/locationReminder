package com.udacity.project4.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser

/**
 * The listener in the class will listen for changes involving users logged-in, users logged-out
 * or change of the current user
 */
class FirebaseUserLiveData : LiveData<FirebaseUser?>() {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val authStateListener = AuthStateListener { value = it.currentUser }

    // Listen to changes happening on the current user
    override fun onActive() = firebaseAuth.addAuthStateListener(authStateListener)

    // Remove listener when the LiveData is inactive (when activity is stopped or destroyed)
    override fun onInactive() = firebaseAuth.removeAuthStateListener(authStateListener)
}

enum class AuthenticationState { LOGGED_IN, LOGGED_OUT}