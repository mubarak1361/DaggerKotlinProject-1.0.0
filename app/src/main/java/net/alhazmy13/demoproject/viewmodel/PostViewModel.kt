package net.alhazmy13.demoproject.viewmodel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import net.alhazmy13.demoproject.data.model.Post

/**
 * @author CIPL0349
 * @created 21/05/18
 */
class PostViewModel(var data: MutableList<Post>) : BaseObservable() {

    var posts = ObservableField<MutableList<PostItemViewModel>>(data.asSequence().map { PostItemViewModel(it) }.toMutableList())

}