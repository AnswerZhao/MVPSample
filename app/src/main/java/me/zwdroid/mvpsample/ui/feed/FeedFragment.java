package me.zwdroid.mvpsample.ui.feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.zwdroid.mvpsample.R;
import me.zwdroid.mvpsample.base.BaseFragment;
import me.zwdroid.mvpsample.ui.login.LoginActivity;

/**
 * Author: zhaowenda
 * Email:  zwdroid@gmail.com
 * Date:   16/10/15 下午4:23
 */

public class FeedFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        String value = getArguments().getString(BUNDLE_KEY);
        View contentView = inflater.inflate(R.layout.fragment_feed,container,false);
        TextView textView = (TextView) contentView.findViewById(R.id.tv);
        Button btn = (Button) contentView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        textView.setText(value);
        return contentView;
    }
}
