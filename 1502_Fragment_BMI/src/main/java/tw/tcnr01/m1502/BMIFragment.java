package tw.tcnr01.m1502;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BMIFragment extends Fragment {


    private BMIListener activityCallback;
    private EditText txtHeight,txtWeight;
    private Button button;

    public interface BMIListener{
        public void onButtonClick(double bmi);
    }

    public BMIFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {  // 取得父活動物件
            activityCallback = (BMIListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "需實作BMIListener");
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bmi, container, false);

        txtHeight = (EditText)view.findViewById(R.id.txtHeight);
        txtWeight = (EditText)view.findViewById(R.id.txtWeight);
        button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;

    }

    public void buttonClicked(View view) {
        double height, weight, bmi;
        // 取得輸入值
        if (txtHeight.getText().toString().trim().length() == 0 || txtWeight.getText().toString().trim().length() == 0) {
            bmi = 0;
        } else {
            height = Double.parseDouble(txtHeight.getText().toString());
            weight = Double.parseDouble(txtWeight.getText().toString());
            // 計算BMI
            height = height / 100.00;
            bmi = weight / (height * height);
        };
        // 呼叫父活動的介面方法
        activityCallback.onButtonClick(bmi);

    }

}
