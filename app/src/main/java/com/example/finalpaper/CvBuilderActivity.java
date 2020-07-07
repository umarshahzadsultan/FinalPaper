package com.example.finalpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;

public class CvBuilderActivity extends AppCompatActivity {

    private EditText nameEt, cityEt, mobilenumberEt, ageEt, emailEt, schoolnameEt, collegenameEt, universitynameEt, degreenameEt, projectnameEt, projectdetailsEt, researchEt, keyskillEt;
    private CheckBox bsCheck, msCheck, phdCheck;

    private Button submitButton;
    DatabaseReference reff;
    Member member = new Member() {
        @NonNull
        @Override
        public Class<?> getDeclaringClass() {
            return null;
        }

        @NonNull
        @Override
        public String getName() {
            return null;
        }

        @Override
        public int getModifiers() {
            return 0;
        }

        @Override
        public boolean isSynthetic() {
            return false;
        }
    };
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_builder);

        nameEt = findViewById(R.id.name);
        cityEt = findViewById(R.id.city);
        ageEt = findViewById(R.id.age);
        mobilenumberEt = findViewById(R.id.number);
        emailEt = findViewById(R.id.email);
        schoolnameEt = findViewById(R.id.school);
        collegenameEt = findViewById(R.id.college);
        universitynameEt = findViewById(R.id.university);
        degreenameEt = findViewById(R.id.universityDegree);
        projectnameEt = findViewById(R.id.project);
        projectdetailsEt = findViewById(R.id.projectdetail);
        researchEt = findViewById(R.id.researchproject);
        keyskillEt = findViewById(R.id.keyskill);
        bsCheck = findViewById(R.id.bs);
        msCheck = findViewById(R.id.ms);
        phdCheck = findViewById(R.id.phd);
        member = new Member() {
            @NonNull
            @Override
            public Class<?> getDeclaringClass() {
                return null;
            }

            @NonNull
            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getModifiers() {
                return 0;
            }

            @Override
            public boolean isSynthetic() {
                return false;
            }
        };
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if(datasnapshot.exists())
                    maxid=(datasnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, city, mobile, age, email, school, college, university, project, project_details, project_background, skills;
                name = nameEt.getText().toString();
                city = cityEt.getText().toString();
                mobile = mobilenumberEt.getText().toString();
                age = ageEt.getText().toString();
                email = emailEt.getText().toString();
                school = schoolnameEt.getText().toString();
                college = collegenameEt.getText().toString();
                university = universitynameEt.getText().toString();
                project = projectnameEt.getText().toString();
                project_details = projectdetailsEt.getText().toString();
                project_background = researchEt.getText().toString();
                skills = keyskillEt.getText().toString();

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("data inserted successfully");
                    }
                });

            }




    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    }
}
}
