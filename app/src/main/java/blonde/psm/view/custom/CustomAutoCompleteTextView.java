package blonde.psm.view.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import blonde.psm.R;
import blonde.psm.view.activity.search.SearchActivity;

public class CustomAutoCompleteTextView extends AppCompatAutoCompleteTextView implements TextWatcher, View.OnTouchListener, View.OnFocusChangeListener {

    private Drawable clearDrawable;
    private Drawable backDrawable;
    private OnFocusChangeListener onFocusChangeListener;
    private OnTouchListener onTouchListener;
    private SearchActivity.OnBackPressed onBackPressedCallback;

    public CustomAutoCompleteTextView(Context context) {
        super(context);
        initView();
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public CustomAutoCompleteTextView(Context context, SearchActivity.OnBackPressed onBackPressedCallback) {
        super(context);
        initView();
        this.onBackPressedCallback = onBackPressedCallback;
    }

    @Override public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.onFocusChangeListener = onFocusChangeListener;
    }

    @Override public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    private void initView() {

        Drawable tempClearDrawable = ContextCompat.getDrawable(getContext(), R.drawable.clear_button);
        clearDrawable = DrawableCompat.wrap(tempClearDrawable);
        DrawableCompat.setTintList(clearDrawable, getHintTextColors());
        clearDrawable.setBounds(0, 0, clearDrawable.getIntrinsicWidth(), clearDrawable.getIntrinsicHeight());

        Drawable tempBackDrawable = ContextCompat.getDrawable(getContext(), R.drawable.back_button);
        backDrawable = DrawableCompat.wrap(tempBackDrawable);
        DrawableCompat.setTintList(backDrawable, getTextColors());
        backDrawable.setBounds(0, 0, backDrawable.getIntrinsicWidth(), backDrawable.getIntrinsicHeight());

        setDrawables(false);

        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);

        addTextChangedListener(this);
    }

    @Override public void onFocusChange(final View view, final boolean hasFocus) {
        if (hasFocus) setDrawables(getText().length() > 0);
        else setDrawables(false);

        if (onFocusChangeListener != null) onFocusChangeListener.onFocusChange(view, hasFocus);
    }

    @Override public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int x = (int) motionEvent.getX();
        if (clearDrawable.isVisible() && x > getWidth() - getPaddingRight() - clearDrawable.getIntrinsicWidth()) {

            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                setError(null);
                setText(null);
            }
            return true;
        }

        if (x < getPaddingLeft() + backDrawable.getIntrinsicWidth()) {
            this.onBackPressedCallback.OnBackPressedCallback();
        }

        if (onTouchListener != null) return onTouchListener.onTouch(view, motionEvent);
        else return false;
    }

    @Override public final void onTextChanged(final CharSequence s, final int start, final int before, final int count) {

        if (isFocused()) setDrawables(s.length() > 0);
    }

    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override public void afterTextChanged(Editable s) {

    }

    private void setDrawables(boolean isClearIconVisible) {
        clearDrawable.setVisible(isClearIconVisible, false);
        setCompoundDrawables(backDrawable, null, isClearIconVisible ? clearDrawable : null, null);
    }
}
