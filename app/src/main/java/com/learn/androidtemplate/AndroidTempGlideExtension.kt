package com.learn.androidtemplate

import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions


@GlideExtension
class AndroidTempGlideExtension private constructor() {

    companion object {

        @GlideOption
        @JvmStatic
        fun profilePhoto(options: RequestOptions){
            options
                .priority(Priority.NORMAL)
                .placeholder(R.drawable.ic_person_white)
                .fallback(R.drawable.ic_person_white)
                .circleCrop()
                .override(36, 36)
        }

        @GlideOption
        @JvmStatic
        fun feedPhoto(options: RequestOptions){
            options
                .priority(Priority.HIGH)
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background)
                .format(DecodeFormat.PREFER_RGB_565)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .centerCrop()
        }
    }


}