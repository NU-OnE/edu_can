package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.apache.tomcat.jni.User;

import com.appointment.Appointment;
import com.appointment.AppointmentDao;
import com.availabillity.Availabillity;
import com.availabillity.AvailabillityDao;
import com.counsellor.Counsellor;
import com.counsellor.CounsellorDao;
import com.student.Student;
import com.student.StudentDao;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.HeaderTokenizer.Token;
import com.token.TokenDao;
import com.user.UserDao;
import com.utilities.ResposeResult;

public class UnitTest {
	
	static AppointmentDao appointment_dao = new AppointmentDao();
	static AvailabillityDao availabillity_dao = new AvailabillityDao();
	static CounsellorDao counsellor_dao = new CounsellorDao();
	static StudentDao student_dao = new StudentDao();
	static UserDao user_dao = new UserDao();
	static TokenDao token_dao = new TokenDao();
	
	ResposeResult response;


	/**----------------------- Appointment Test - Start ------------------------------ */
	
	@org.junit.Test
    public void getAllAppointments() {
		response = appointment_dao.getAllAppointments();
        assertNotNull(response.getResult());
    }
	
	@org.junit.Test
    public void saveAppointment() {
		Appointment appointmnet = new Appointment();
		appointmnet.setConsultant_id(1);
		appointmnet.setDate("2018-04-24");
		appointmnet.setDay("Sunday");
		appointmnet.setStudent_id(2);
		appointmnet.setTime("04.55Pm");
		appointmnet.setUser_id(2);
		
		response = appointment_dao.store(appointmnet);
        assertFalse(response.getIs_error());
    }
	
	@org.junit.Test
    public void getUserAppointment() {
		response = appointment_dao.getUserAppointment(1);
        assertNotNull(response.getResult());
    }
	
	/**----------------------- Appointment Test - End ------------------------------ */
	
	
	
	/**----------------------- Availability Test - Start ------------------------------ */
	@org.junit.Test
    public void getAllAvailabilities() {
		response = availabillity_dao.getAllAvilabillities();
        assertNotNull(response.getResult());
    }
	
	@org.junit.Test
    public void saveAvailabillity() {
		Availabillity availabillity = new Availabillity();
		availabillity.setConsultant_id(1);
		availabillity.setSun("1.00Pm");
		availabillity.setMon("2.00Pm");
		availabillity.setTue("3.00pm");
		availabillity.setWed("4.00pm");
		availabillity.setThu("5.00pm");
		availabillity.setFri("6.00pm");
		availabillity.setSat("7.00pm");
	
		response = availabillity_dao.store(availabillity);
        assertFalse(response.getIs_error());
    }
	
	/**----------------------- Appointment Test - End ------------------------------ */
	
	
	/**----------------------- Counselors Test - Start ------------------------------ */
	@org.junit.Test
    public void getAllCounsellors() {
		response = counsellor_dao.getAllCounsellors();
        assertNotNull(response.getResult());
    }
	
	@org.junit.Test
    public void saveCounsellor() {
		Counsellor counsellor = new Counsellor();
		counsellor.setContact_no("119");
		counsellor.setEmail("mail@mail.com");
		counsellor.setName("John Cooper");
		counsellor.setSalute("Mr");
	
		response = counsellor_dao.store(counsellor);
        assertFalse(response.getIs_error());
    }
	
	/**----------------------- Counselors Test - End ------------------------------ */
	
	
	/**----------------------- Student Test - Start ------------------------------ */
	@org.junit.Test
    public void getAllStudents() {
		response = student_dao.getAllStudents();
        assertNotNull(response.getResult());
    }
	
	@org.junit.Test
    public void saveStudent() {
		Student student = new Student();
		student.setContact_no("118");
		student.setEmail("thili@mail.com");
		student.setGender("Male");
		student.setName("Thiilina Nuwan");
	
		response = student_dao.addStudent(student);
        assertFalse(response.getIs_error());
    }
	
	/**----------------------- Student Test - End ------------------------------ */
	
	
	/**----------------------- User Test - Start ------------------------------ */
	@org.junit.Test
    public void getAllUsers() {
		response = user_dao.getAllUsers();
        assertNotNull(response.getResult());
    }
	
	@org.junit.Test
    public void saveUser() {
		
		com.user.User user = new com.user.User();
		user.setActive(1);
		user.setName("John Doe");
		user.setPassword("123");
		user.setRole("Admin");
		
		response = user_dao.store(user);
        assertFalse(response.getIs_error());
    }
	
	/**----------------------- User Test - End ------------------------------ */
	
	/**----------------------- Token Test - Start ------------------------------ */
	@org.junit.Test
    public void newToken() {
		com.user.User user = new com.user.User();
		user.setActive(1);
		user.setName("John Doe");
		user.setPassword("123");
		user.setRole("Admin");
		
		response = token_dao.newToken(user);
        assertNotNull(response.getResult());
    }
	
	@org.junit.Test
    public void store() {
		
		com.token.Token token = new com.token.Token();
		token.setName("Testing");
		token.setExpire_at("2017-01-01");
		token.setName("John Cooper");
		token.setType("Admin");
		token.setUser_id(1);
		
		response = token_dao.store(token);
        assertFalse(response.getIs_error());
    }
	
	/**----------------------- Token Test - End ------------------------------ */
}
