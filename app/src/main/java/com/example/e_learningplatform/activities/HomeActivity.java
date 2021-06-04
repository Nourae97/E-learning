package com.example.e_learningplatform.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

import com.example.e_learningplatform.R;
import com.example.e_learningplatform.fragments.AttendanceFragment;
import com.example.e_learningplatform.fragments.GradesFragment;
import com.example.e_learningplatform.fragments.NotesFragment;
import com.example.e_learningplatform.fragments.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    private final ScheduleFragment scheduleFragment = new ScheduleFragment();
    private final AttendanceFragment attendanceFragment = new AttendanceFragment();
    private final GradesFragment gradesFragment = new GradesFragment();
    private final NotesFragment notesFragment = new NotesFragment();

    @BindView(R.id.bottomNavView)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setCurrentFragment(scheduleFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.scheduleFragmentItem:
                            setCurrentFragment(scheduleFragment);
                            return true;

                        case R.id.attendanceFragmentItem:
                            setCurrentFragment(attendanceFragment);
                            return true;

                        case R.id.gradesFragmentItem:
                            setCurrentFragment(gradesFragment);
                            return true;

                        case R.id.notesFragmentItem:
                            setCurrentFragment(notesFragment);
                            return true;

                    }
                    return false;
                });

    }

    private void setCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.mainContainer,fragment).
                commit();
    }

}
