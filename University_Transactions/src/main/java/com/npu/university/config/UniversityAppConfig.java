package com.npu.university.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.npu.university.aspect.LoggingAspect;
import com.npu.university.dao.AccountDAO;
import com.npu.university.dao.jdbc.AccountMockedDaoImpl;
import com.npu.university.services.PayPalPaymentServiceImpl;
import com.npu.university.services.PaymentService;
import com.npu.university.services.StudentCheckoutServiceImpl;
import com.npu.university.services.TutionCalculatorService;
import com.npu.university.services.TutionForNationalUniversity;
import com.npu.university.services.TutionForOhioStUniversity;
import com.npu.university.services.WellsFargoPaymentServiceImpl;

@Configuration
@EnableAspectJAutoProxy
@Lazy(value=true)
public class UniversityAppConfig {
	//<bean id="studentCheckout" class="com.npu.services.StudentCheckoutServiceImpl" >
	
	@Scope("prototype")
	@Bean
	public StudentCheckoutServiceImpl   studentCheckout(){
		return new  StudentCheckoutServiceImpl();
		
	}
	
	
	
	//<bean id="tutionFeeOU" class="com.npu.services.TutionForOhioStUniversity" />
	@Bean
	public TutionCalculatorService tutionFeeOU(){
		TutionCalculatorService tutFeeO = new TutionForOhioStUniversity();
		return tutFeeO;
	}
	
	@Bean
	public TutionCalculatorService tutionCalculatorServiceNU(){
		TutionCalculatorService tutFeeN = new TutionForNationalUniversity();
		return tutFeeN;
	}
	@Bean
	public PaymentService paymentServicePP(){
		PaymentService payServicePP = new PayPalPaymentServiceImpl();
		return payServicePP;
	}
	//<bean id="paymentServiceWF" class="com.npu.services.WellsFargoPaymentServiceImpl" />
	@Bean
	public PaymentService paymentServiceWF(){
		PaymentService payServiceWF = new WellsFargoPaymentServiceImpl();
		return payServiceWF;
	}
	
	@Bean
	public AccountDAO  accountDao(){
		AccountDAO  accountDao  = new AccountMockedDaoImpl();
		return accountDao;
	}
	
	@Bean
	public LoggingAspect logger(){
		LoggingAspect   logger = new LoggingAspect();
		return logger;
	}

}
