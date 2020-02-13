package net.alhazmy13.demoproject.viewmodel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import net.alhazmy13.demoproject.data.model.Post
/**
 * @author CIPL0349
 * @created 21/05/18
 */
class PostItemViewModel(post: Post):BaseObservable(){

    var title = ObservableField<String>(post.title)
    var body = ObservableField<String>(post.body)

}
