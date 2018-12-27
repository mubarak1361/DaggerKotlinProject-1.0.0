package net.alhazmy13.demoproject.component.interfaces

import android.databinding.BindingAdapter
import android.widget.ListView
import net.alhazmy13.demoproject.data.model.Post

/**
 * @author CIPL0349
 * @created 21/05/18
 */
interface IListViewBinding{
    @BindingAdapter("layoutResourceId","dataSet")
    fun <T>setAdapter(listView: ListView,layoutResourceId:Int,dataSet:MutableList<T>?)
}