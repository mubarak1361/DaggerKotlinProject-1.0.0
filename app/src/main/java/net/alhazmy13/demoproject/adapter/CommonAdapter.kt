package net.alhazmy13.demoproject.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import net.alhazmy13.demoproject.BR

/**
 * @author CIPL0349
 * @created 21/05/18
 */
class CommonAdapter<T>(@LayoutRes private val layoutResourceId:Int, private val values: MutableList<T>) : BaseAdapter() {

    override fun getItem(index: Int): T {
        return values[index]
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getCount(): Int {
        return values.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding:ViewDataBinding

        if(convertView == null) {
            binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), layoutResourceId, parent, false)
            binding.root.tag  = binding
        }else{
            binding = convertView.tag as ViewDataBinding
        }

        binding.setVariable(BR.viewModel, getItem(position))
        binding.executePendingBindings()

        return binding.root
    }

}

