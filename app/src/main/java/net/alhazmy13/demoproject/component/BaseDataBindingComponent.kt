package net.alhazmy13.demoproject.component

import android.databinding.DataBindingComponent
import net.alhazmy13.demoproject.component.Binding.BaseListViewBinding
import net.alhazmy13.demoproject.component.interfaces.IListViewBinding

/**
 * @author CIPL0349
 * @created 21/05/18
 */
class BaseDataBindingComponent:DataBindingComponent{
    override fun getIListViewBinding(): IListViewBinding {
        return BaseListViewBinding()
    }

}