package com.muqing.ViewUI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.muqing.R;
import com.muqing.databinding.ViewSeetingSwitchtBinding;
import com.muqing.databinding.ViewSeetingTextBinding;

public class SettingSwitch extends LinearLayoutCompat {
    public SettingSwitch(Context context) {
        super(context);
        Init(context, null);
    }

    public SettingSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context, attrs);
    }

    public SettingSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private ViewSeetingSwitchtBinding binding;

    private void Init(Context context, AttributeSet attrs) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_seeting_switcht, this);
        binding = ViewSeetingSwitchtBinding.bind(inflate);
        setClickable(true);
        setFocusable(true);
        if (attrs != null) {
            @SuppressLint({"Recycle", "CustomViewStyleable"}) TypedArray typedArray =
                    context.obtainStyledAttributes(attrs, R.styleable.SettingTextView);
            String title = typedArray.getString(R.styleable.SettingTextView_title);
            String message = typedArray.getString(R.styleable.SettingTextView_message);
            boolean enabled = typedArray.getBoolean(R.styleable.SettingTextView_enabled, true);
            setEnabled(enabled);
            setTitle(title);
            setMessage(message);
        }

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        binding.MaterialSwitch.setEnabled(enabled);
        binding.title.setEnabled(enabled);
        binding.message.setEnabled(enabled);
        if (enabled) {
            binding.getRoot().setOnClickListener(view -> binding.MaterialSwitch.setChecked(!binding.MaterialSwitch.isChecked()));
        }
    }

    public void setTitle(String title) {
        binding.title.setText(title);
    }

    public void setMessage(String message) {
        if (message == null) {
            return;
        }
        binding.message.setVisibility(VISIBLE);
        binding.message.setText(message);
    }

    public void setChecked(boolean jcgx) {
        binding.MaterialSwitch.setChecked(jcgx);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener jcgx) {
        binding.MaterialSwitch.setOnCheckedChangeListener(jcgx);
    }
}
