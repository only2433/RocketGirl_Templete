package com.littlefox.storybook.dialog;

import com.littlefox.storybook.lib.common.CommonUtils;
import com.littlefox.storybook.lib.common.Font;
import com.littlefox.storybook.rocketgirl.R;

import android.app.Dialog;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class WriterDialog extends Dialog
{
	public WriterDialog(Context context, int theme)
	{
		super(context, theme);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_writer);
		mContext = context;
		init();
		initFont();
		settingStyleText();
	}

	private Context mContext;
	private ImageView _CloseButton;
	private TextView _WriterText;
	private TextView _WriterNameText;
	private TextView _WriterInformationText;
	
	
	
	
	private void init()
	{
		_CloseButton 	= (ImageView)findViewById(R.id.writer_close_btn);
		_CloseButton.setOnClickListener(mClickListener);
		_WriterText		= (TextView)findViewById(R.id.writer_type_text);
		_WriterNameText = (TextView)findViewById(R.id.writer_naming_text);
		_WriterInformationText	= (TextView)findViewById(R.id.writer_information_text);
		_WriterInformationText.setMovementMethod(new ScrollingMovementMethod());
	}
	
	private void initFont()
	{
		_WriterText.setTypeface(Font.getInstance(mContext).getRobotoBold());
		_WriterNameText.setTypeface(Font.getInstance(mContext).getRobotoBold());
		_WriterInformationText.setTypeface(Font.getInstance(mContext).getRobotoMedium());
	}
	
	private void settingStyleText()
	{
		final SpannableStringBuilder builder = new SpannableStringBuilder(_WriterInformationText.getText().toString());
		builder.setSpan(new AbsoluteSizeSpan(CommonUtils.getInstance(mContext).getPixel(72)), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		_WriterInformationText.setText("");
		_WriterInformationText.append(builder);
	}
	
	private View.OnClickListener mClickListener = new View.OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			if(v.getId() == R.id.writer_close_btn)
			{
				dismiss();
			}
		}
	};
	
	
}
