package com.humber.androidactivitylifecycle.model

import android.os.Parcel
import android.os.Parcelable


class LoginModel(): Parcelable {

    private var login: String? = null;
    private var online: Boolean = true;

    constructor(parcel: Parcel) : this() {
        login = parcel.readString()
        online = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeByte(if (online) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginModel> {
        override fun createFromParcel(parcel: Parcel): LoginModel {
            return LoginModel(parcel)
        }

        override fun newArray(size: Int): Array<LoginModel?> {
            return arrayOfNulls(size)
        }
    }
    public fun getLogin() = login;
    public fun getOnline() = online;

    public fun setLogin(login:String){
        this.login = login;
    }

    public fun setOnline(online:Boolean){
        this.online = online;
    }

}