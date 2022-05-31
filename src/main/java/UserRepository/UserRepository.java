package UserRepository;

   import com.example.usersmanagementsoftware.model.UserModel;
   import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserModel,Integer>

    {


        UserModel findById(String id);

        UserModel findByEmail(String email);

        UserModel findByAge(Integer age);

        UserModel findByAge(String role);



        @Query("SELECT s FROM UserModel s WHERE s.passWord=?1 and s.userName=?2")
        UserModel fineByUserNameAndPassword(String userName ,Integer passWord);

    }
    
    
