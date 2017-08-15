package com.gzfgeh.iosdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Description:
 * Created by guzhenfu on 2016/12/14 15:29.
 */

public class IOSDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout lLayout_bg;
    private TextView txt_title;
    private TextView txt_msg;
    private ViewGroup contentView;
    private Button btn_neg;
    private Button btn_pos;
    private ImageView img_line;
    private ImageView content_line;
    private ImageView title_line;
    private Display display;
    private LinearLayout btn_layout;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;
    private boolean outSideEnable = true;
    private boolean netBtnBgr = false;
    private boolean posBtnBgr = false;
    private float percentWidth = 0f;

    public IOSDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public IOSDialog(Context context, float percentWidth) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        this.percentWidth = percentWidth;
    }

    public IOSDialog builder() {
        View view = LayoutInflater.from(context).inflate(
                R.layout.ios_dialog_layout, null);

        // Dialog
        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
        txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setVisibility(View.GONE);
        txt_msg = (TextView) view.findViewById(R.id.txt_msg);
        txt_msg.setVisibility(View.GONE);
        btn_neg = (Button) view.findViewById(R.id.btn_neg);
        btn_neg.setVisibility(View.GONE);
        btn_pos = (Button) view.findViewById(R.id.btn_pos);
        btn_pos.setVisibility(View.GONE);
        img_line = (ImageView) view.findViewById(R.id.img_line);
        img_line.setVisibility(View.GONE);
        contentView = (FrameLayout) view.findViewById(R.id.content_view);
        btn_layout = (LinearLayout) view.findViewById(R.id.btn_layout);
        content_line = (ImageView) view.findViewById(R.id.content_line);
        title_line = (ImageView) view.findViewById(R.id.title_line);
        // Dialog
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);
        dialog.setCancelable(false);
        // dialog
        if (percentWidth == 0f){
            percentWidth = 0.7f;
        }else{
            percentWidth = 0.9f;
        }

        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * percentWidth), LinearLayout.LayoutParams.WRAP_CONTENT));
        return this;
    }

    /**
     * 设置标题
     * @param title
     * @return
     */
    public IOSDialog setTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            txt_title.setText("");
        } else {
            txt_title.setText(title);
        }
        return this;
    }

    /**
     * 设置标题和标题的点击事件
     * @param title
     * @param listener
     * @return
     */
    public IOSDialog setTitle(String title, final View.OnClickListener listener) {
        showTitle = true;
        if ("".equals(title)) {
            txt_title.setText("");
        } else {
            txt_title.setText(title);
        }

        txt_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                    dialog.dismiss();
                }
            }
        });
        return this;
    }

    /**
     * 设置标题大小
     * @param size
     * @return
     */
    public IOSDialog setTitleSize(@DimenRes int size) {
        txt_title.setTextSize(context.getResources().getDimension(size));
        return this;
    }

    /**
     * 设置标题颜色
     * @param color
     * @return
     */
    public IOSDialog setTitleColor(@ColorRes int color) {
        txt_title.setTextColor(context.getResources().getColor(color));
        return this;
    }

    /**
     * 设置标题颜色
     * @param color
     * @return
     */
    public IOSDialog setTitleColor(String color) {
        txt_title.setTextColor(Color.parseColor(color));
        return this;
    }

    /**
     * 设置标题背景颜色
     * @param color
     * @return
     */
    public IOSDialog setTitleBackground(@ColorRes int color) {
        txt_title.setBackgroundResource(color);
        return this;
    }

    /**
     * 设置标题背景颜色
     * @param color
     * @return
     */
    public IOSDialog setTitleBackground(String color) {
        txt_title.setBackgroundColor(Color.parseColor(color));
        return this;
    }


    /**
     * 设置内容大小
     * @param size
     * @return
     */
    public IOSDialog setMsgSize(@DimenRes int size) {
        txt_msg.setTextSize(context.getResources().getDimension(size));
        return this;
    }

    /**
     * 设置Msg
     * @param msg
     * @return
     */
    public IOSDialog setMsg(String msg) {
        showMsg = true;
        if ("".equals(msg)) {
            txt_msg.setText("");
        } else {
            txt_msg.setText(msg);
        }
        return this;
    }

    /**
     * 设置Msg
     * @param msg
     * @return
     */
    public IOSDialog setMsg(SpannableStringBuilder msg) {
        showMsg = true;
        if ("".equals(msg)) {
            txt_msg.setText("");
        } else {
            txt_msg.setText(msg);
        }
        return this;
    }

    /**
     * 设置msg和msg点击事件
     * @param msg
     * @param listener
     * @return
     */
    public IOSDialog setMsg(String msg, final View.OnClickListener listener) {
        showMsg = true;
        if ("".equals(msg)) {
            txt_msg.setText("");
        } else {
            txt_msg.setText(msg);
        }

        txt_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onClick(v);
                    dialog.dismiss();
                }
            }
        });
        return this;
    }

    /**
     * 设置标题颜色
     * @param color
     * @return
     */
    public IOSDialog setMsgColor(@ColorRes int color) {
        txt_msg.setTextColor(context.getResources().getColor(color));
        return this;
    }

    /**
     * 设置标题颜色
     * @param color
     * @return
     */
    public IOSDialog setMsgColor(String color) {
        txt_msg.setTextColor(Color.parseColor(color));
        return this;
    }

    /**
     * 设置标题背景颜色
     * @param color
     * @return
     */
    public IOSDialog setMsgBackground(@ColorRes int color) {
        txt_msg.setBackgroundResource(color);
        title_line.setVisibility(View.GONE);
        return this;
    }

    /**
     * 设置标题背景颜色
     * @param color
     * @return
     */
    public IOSDialog setMsgBackground(String color) {
        txt_msg.setBackgroundColor(Color.parseColor(color));
        title_line.setVisibility(View.GONE);
        return this;
    }


    /**
     * 添加自定义Msg布局
     * @param view
     * @return
     */
    public IOSDialog setContentView(@NonNull View view){
        txt_msg.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        contentView.removeAllViews();
        contentView.addView(view);
        content_line.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 添加自定义Msg布局
     * @param view
     * @param listener
     * @return
     */
    public IOSDialog setContentView(@NonNull View view, final View.OnClickListener listener){
        txt_msg.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        contentView.removeAllViews();
        contentView.addView(view);
        content_line.setVisibility(View.VISIBLE);

        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * 添加自定义Msg布局
     * @param id
     * @return
     */
    public IOSDialog setContentView(@LayoutRes int id){
        txt_msg.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        contentView.removeAllViews();
        View view = View.inflate(context, id, null);
        contentView.addView(view);
        content_line.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 添加自定义Msg布局
     * @param id
     * @param listener
     * @return
     */
    public IOSDialog setContentView(@LayoutRes int id, final View.OnClickListener listener){
        txt_msg.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        contentView.removeAllViews();
        View view = View.inflate(context, id, null);
        contentView.addView(view);
        content_line.setVisibility(View.VISIBLE);

        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public IOSDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public IOSDialog setPositiveButton(String text) {
        showPosBtn = true;
        if ("".equals(text)) {
            btn_pos.setText("");
        } else {
            btn_pos.setText(text);
        }
        return this;
    }

    /**
     * 设置确定按钮和点击事件
     * @param text
     * @param listener
     * @return
     */
    public IOSDialog setPositiveButton(String text,
                                       final View.OnClickListener listener) {
        showPosBtn = true;
        if ("".equals(text)) {
            btn_pos.setText("");
        } else {
            btn_pos.setText(text);
        }
        btn_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null)
                    listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * 设置确定按钮大小
     * @param size
     * @return
     */
    public IOSDialog setPositiveBtnSize(@DimenRes int size) {
        btn_pos.setTextSize(context.getResources().getDimension(size));
        return this;
    }

    /**
     * 设置确定按钮颜色
     * @param color
     * @return
     */
    public IOSDialog setPositiveBtnColor(@ColorRes int color) {
        btn_pos.setTextColor(context.getResources().getColor(color));
        return this;
    }

    /**
     * 设置确定按钮颜色
     * @param color
     * @return
     */
    public IOSDialog setPositiveBtnColor(String color) {
        btn_pos.setTextColor(Color.parseColor(color));
        return this;
    }

    /**
     * 设置确定按钮背景颜色
     * @param color
     * @return
     */
    public IOSDialog setPositiveBtnBackground(@ColorRes int color) {
        btn_pos.setBackgroundResource(color);
        posBtnBgr = true;
        return this;
    }

    /**
     * 设置确定按钮背景颜色
     * @param color
     * @return
     */
    public IOSDialog setPositiveBtnBackground(String color) {
        btn_pos.setBackgroundColor(Color.parseColor(color));
        posBtnBgr = true;
        return this;
    }

    /**
     * 设置确定按钮大小
     * @param size
     * @return
     */
    public IOSDialog seNegativeBtnSize(@DimenRes int size) {
        btn_neg.setTextSize(context.getResources().getDimension(size));
        return this;
    }

    /**
     * 设置取消按钮和点击事件
     * @param text
     * @param listener
     * @return
     */
    public IOSDialog setNegativeButton(String text,
                                       final View.OnClickListener listener) {
        showNegBtn = true;
        if ("".equals(text)) {
            btn_neg.setText("");
        } else {
            btn_neg.setText(text);
        }
        btn_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * 设置确定按钮颜色
     * @param color
     * @return
     */
    public IOSDialog setNegativeBtnColor(@ColorRes int color) {
        btn_neg.setTextColor(context.getResources().getColor(color));
        return this;
    }

    /**
     * 设置确定按钮颜色
     * @param color
     * @return
     */
    public IOSDialog setNegativeBtnColor(String color) {
        btn_neg.setTextColor(Color.parseColor(color));
        return this;
    }

    /**
     * 设置确定按钮背景颜色
     * @param color
     * @return
     */
    public IOSDialog setNegativeBtnBackground(@ColorRes int color) {
        btn_neg.setBackgroundResource(color);
        netBtnBgr = true;
        return this;
    }

    /**
     * 设置确定按钮背景颜色
     * @param color
     * @return
     */
    public IOSDialog setNegativeBtnBackground(String color) {
        btn_neg.setBackgroundColor(Color.parseColor(color));
        netBtnBgr = true;
        return this;
    }

    /**
     * 点击外部是否消失
     * @param enable
     * @return
     */
    public IOSDialog setCanceledOnTouchOutside(boolean enable){
        outSideEnable = enable;
        dialog.setCanceledOnTouchOutside(enable);
        return this;
    }

    private void setLayout() {
        if (showTitle) {
            txt_title.setVisibility(View.VISIBLE);
        }else{
            txt_title.setVisibility(View.GONE);
            title_line.setVisibility(View.GONE);
        }

        if (showMsg) {
            txt_msg.setVisibility(View.VISIBLE);
        }else{
            txt_msg.setVisibility(View.GONE);
        }

        if (!showTitle && !showMsg){
            lLayout_bg.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
            content_line.setVisibility(View.GONE);
        }

        if (!showTitle && showMsg){
            LinearLayout.LayoutParams params = ((LinearLayout.LayoutParams)txt_msg.getLayoutParams());
            params.setMargins(40, 40, 40, 40);
            txt_msg.setLayoutParams(params);
            txt_msg.setTextColor(Color.parseColor("#333333"));
        }

        if (!showPosBtn && !showNegBtn) {
            btn_layout.setVisibility(View.GONE);
        }

        if (showPosBtn && showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            if (!posBtnBgr)
                btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
            btn_neg.setVisibility(View.VISIBLE);
            if (!netBtnBgr)
                btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
            img_line.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            if (!posBtnBgr)
                btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }

        if (!showPosBtn && showNegBtn) {
            btn_neg.setVisibility(View.VISIBLE);
            if (!netBtnBgr)
                btn_neg.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }
        dialog.setCanceledOnTouchOutside(outSideEnable);
    }

    public void show() {
        setLayout();
        if(!dialog.isShowing())
            dialog.show();
    }

    public void dismiss(){
        if (dialog.isShowing()){
            dialog.dismiss();
        }
    }

    /**
     * loading dialog
     */
    public IOSDialog setLoadingView(){
        setContentView(R.layout.loading_layout);
        return this;
    }

    /**
     * loading dialog
     */
    public IOSDialog setLoadingView(@ColorRes int color){
        View view = LayoutInflater.from(context).inflate(R.layout.loading_layout, null);
        ProgressWheel progressWheel = (ProgressWheel) view.findViewById(R.id.progress_wheel);
        progressWheel.setBarColor(context.getResources().getColor(color));
        setContentView(view);
        return this;
    }
}
