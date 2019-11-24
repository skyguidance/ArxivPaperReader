/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.model

import android.os.Parcel
import android.os.Parcelable


/**
 * Weblink: result.get(0).get(0).get(0)
 * Title: result.get(0).get(1).get(0)
 * AuthorCount:result.get(0).get(2).size
 * Author:result.get(0).get(2).get(N)
 * Abstract:result.get(0).get(3).get(0)
 * Catorgary:result.get(0).get(4).get(0)
 * UpdateTime:result.get(0).get(5).get(0)
 * PDFlink: result.get(0).get(8).get(0)
 * ArxivID: result.get(0).get(9).get(0)
 */

/**
 * The Data Class for the a PaperDetail.
 */
data class PaperBean(
    var Weblink: String,
    var Title: String,
    var Author: String,
    var Abstract: String,
    var Catorgary: String,
    var UpdateTime: String,
    var PDFLink: String,
    var ArxivID: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Weblink)
        parcel.writeString(Title)
        parcel.writeString(Author)
        parcel.writeString(Abstract)
        parcel.writeString(Catorgary)
        parcel.writeString(UpdateTime)
        parcel.writeString(PDFLink)
        parcel.writeString(ArxivID)
    }

    override fun describeContents(): Int {
        return 0
    }


    /**
     * The Data Class creator.
     */
    companion object CREATOR : Parcelable.Creator<PaperBean> {
        override fun createFromParcel(parcel: Parcel): PaperBean {
            return PaperBean(parcel)
        }

        override fun newArray(size: Int): Array<PaperBean?> {
            return arrayOfNulls(size)
        }
    }

}
