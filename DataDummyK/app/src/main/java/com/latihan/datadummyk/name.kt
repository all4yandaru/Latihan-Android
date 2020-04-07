package com.latihan.datadummyk

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name(
    var name: String
):Parcelable