package com.muqing.ViewUI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDialog<ViewBindingType extends ViewBinding> extends BottomSheetDialog {


    public ViewBindingType binding;
    public BaseDialog(Context context) {
        super(context);
        binding = getViewBindingObject(LayoutInflater.from(context), null, 0);
        setContentView(binding.getRoot());
    }

    protected abstract void initView();
    /**
     * 获取 ViewBinding 实例（由子类实现）
     */
    protected abstract ViewBindingType getViewBindingObject(LayoutInflater inflater, ViewGroup parent, int viewType);
}
