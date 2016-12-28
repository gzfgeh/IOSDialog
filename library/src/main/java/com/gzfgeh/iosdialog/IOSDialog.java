package com.gzfgeh.iosdialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
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
    private Display display;
    private LinearLayout btn_layout;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;
    private boolean outSideEnable = true;

    public IOSDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
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
        // Dialog
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);
        dialog.setCancelable(false);
        // dialog
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.7), LinearLayout.LayoutParams.WRAP_CONTENT));
        return this;
    }

    public IOSDialog setTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            txt_title.setText("");
        } else {
            txt_title.setText(title);
        }
        return this;
    }

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

    public IOSDialog setMsg(String msg) {
        showMsg = true;
        if ("".equals(msg)) {
            txt_msg.setText("");
        } else {
            txt_msg.setText(msg);
        }
        return this;
    }

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
     * 添加自定义Msg布局
     * @param view
     * @return
     */
    public IOSDialog setContentView(@NonNull View view){
        txt_msg.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        contentView.removeAllViews();
        contentView.addView(view);
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

        contentView.setOnClickListener(listener);
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

    public IOSDialog setCanceledOnTouchOutside(boolean enable){
        outSideEnable = enable;
        dialog.setCanceledOnTouchOutside(enable);
        return this;
    }

    private void setLayout() {
        if (!showTitle && !showMsg) {
            txt_title.setText("");
            txt_title.setVisibility(View.VISIBLE);
        }

        if (showTitle) {
            txt_title.setVisibility(View.VISIBLE);
        }

        if (showMsg) {
            txt_msg.setVisibility(View.VISIBLE);
        }

        if (!showPosBtn && !showNegBtn) {
            btn_layout.setVisibility(View.GONE);
        }

        if (showPosBtn && showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
            btn_neg.setVisibility(View.VISIBLE);
            btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
            img_line.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }

        if (!showPosBtn && showNegBtn) {
            btn_neg.setVisibility(View.VISIBLE);
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
}
