package net.alhazmy13.demoproject.component.Binding

import android.widget.ListView
import net.alhazmy13.demoproject.adapter.CommonAdapter
import net.alhazmy13.demoproject.component.interfaces.IListViewBinding
import net.alhazmy13.demoproject.data.model.Post

/**
 * @author CIPL0349
 * @created 21/05/18
 */
class BaseListViewBinding:IListViewBinding{
    override fun <T>setAdapter(listView: ListView, layoutResourceId: Int, dataSet: MutableList<T>?) {
        if(dataSet!=null) {
            var adapter = CommonAdapter( layoutResourceId, dataSet)
            listView.adapter = adapter
        }
    }

}