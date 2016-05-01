package com.example.glmgracy.currencies;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by glmgracy on 16/5/1.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mMainActivity;
    private Button mCalcButton;
    private TextView mConvertedTextView;
    private EditText mAmountEditText;
    private Spinner mForSpinner, mHomSpinner;

    public  MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        //get the activity under test
        mMainActivity = getActivity();
        //assign references to our views
        mCalcButton = (Button) mMainActivity.findViewById(R.id.btn_calc);
        mConvertedTextView = (TextView) mMainActivity.findViewById(R.id.txt_converted);
        mAmountEditText = (EditText) mMainActivity.findViewById(R.id.edt_amount);
        mForSpinner = (Spinner) mMainActivity.findViewById(R.id.spn_for);
        mHomSpinner = (Spinner) mMainActivity.findViewById(R.id.spn_hom);

    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
