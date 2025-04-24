package com.example.nikhilbharatV3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	 
	@Autowired
	UserDetailsService userDetailsService; 
	
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}
	@Bean
	SecurityContextRepository securityContextRepository() {
		return new DelegatingSecurityContextRepository(new RequestAttributeSecurityContextRepository()
				,new HttpSessionSecurityContextRepository());
	}
	
	@Bean
	AuthenticationManager authManager() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		
		return new ProviderManager(provider);
		}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		
			.requestMatchers("/",
					"/login",
					"/registration",
					"/index",
					"/registration",
					"/logoutSuccessUrl",
					"/logout",
					"/registration**",
	                "/index2",
	                "/edit_product",
	                "/new_product",
	                "/edit/{id}",
	                "/delete/{id}",
	                "/save",
	                "/search",
	                "/new",
	                "/joblist",
	                "/icardadsfw4pori3409wru8efuidsjfeer8u89ewur89ew89t7er98t7we89rip9ei0erjgi0fjg89erwut7er98thdfvjnckjbnr89wyterwi7t9eongkdfsjnvurwii7erhfoergnsdu9gyer89tu9ewrutoernjgerw89ew9rtuew09rtuew90rtjeriogw9er8w9t7e9rghdfogvjndfkjvn",
	                "/image/saveImageDetails",
	                "/image/display/{id}",
	                "/image/imageDetails",
	                "/image/show",
	                "/typAnyThing",
	                "/typAnyThing2",
	                "/typAnyThingEdit",
	                "/typAnyThing/saveImageDetails",
	                "/typAnyThing/display/{id}",
	                "/typAnyThing/imageDetails",
	                "/typAnyThing/show",
	                "/edit/{id}",
	                "/delete/{id}",
	                "videos/{title}",
	                "/indexSlider",
	                "/indexPdfReader",
	                "/indexTutorials",
	                "/livechat",
	                "/membership",
	                "/gallary",
	                "/aboutUs",
	                "/gallery_2",
	                "/indexVideolist",
	                "/aAndnVideolist",
	                "/anVideolist",
	                "/asmVideolist",
	                "/biharVideolist",
	                "/cgVideolist",
	                "/delhiVideolist",
	                "/gujratVideolist",
	                "/jhVideolist",
	                "/kaVideolist",
	                "/mhVideolist",
	                "/mpVideolist",
	                "/odVideolist",
	                "/teVideolist",
	                "/triVideolist",
	                "/ukVideolist",
	                "/upVideolist",
	                "/westBengalVideolist",
	                "/photos",
	                "/indexPhoto_gallary",
	                "/aAndnPhoto_gallary",
	                "/anPhoto_gallary",
	                "/asmPhoto_gallary",
	                "/biharPhoto_gallary",
	                "/cgPhoto_gallary",
	                "/delhiPhoto_gallary",
	                "/gujratPhoto_gallary",
	                "/jhPhoto_gallary",
	                "/kaPhoto_gallary",
	                "/mhPhoto_gallary",
	                "/mpPhoto_gallary",
	                "/odPhoto_gallary",
	                "/tePhoto_gallary",
	                "/triPhoto_gallary",
	                "/ukPhoto_gallary",
	                "/upPhoto_gallary",
	                "/westBengalPhoto_gallary",
	                "/westBengal",
	                "/gujrat",
	                "/bihar",
	                "/delhi",
	                "/cg",
	                "/od",
	                "/an",
	                "/te",
	                "/aAndn",
	                "/mh",
	                "/ka",
	                "/asm",
	                "/tri",
	                "/jh",
	                "/up",
	                "/uk",
	                "/mp",
	                "/admin",
	                "revel/lib/font-awesome/css/**",
	                "revel/lib/animate/**",
	                "revel/lib/ionicons/css/**",
	                "revel/lib/owlcarousel/assets/**",
	                "/revel/lib/magnific-popup/**",
	                "/revel/lib/ionicons/css/**",
	                "/revel/css/**",
	                "/images/barrackporeLockshobha/**",
	                "/images/dumdumLockshobah/**",
	                "/images/bangaonLockshobha/**",
	                "/revel/lib/jquery/**",
	                "/revel/lib/bootstrap/js/**",
	                "/revel/lib/easing/**",
	                "/revel/lib/superfish/**",
	                "/revel/lib/superfish/**",
	                "/revel/lib/wow/**",
	                "/revel/lib/owlcarousel/**",
	                "/revel/lib/magnific-popup/**",
	                "/revel/lib/sticky/**",
	                "https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY",
	                "/revel/contactform/**",
	                "/revel/js/**",
	                "https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Raleway:300,400,500,700,800|Montserrat:300,400,700",
	                "/revel/img/**",
	                "/revel/img/**",
	                "/img/logo/**",
	                "https://bootstrapmade.com/reveal-bootstrap-corporate-template/**",
	                "http://daneden.me/animate/**",
	                "http://opensource.org/licenses/MIT/**",
	                "https://getbootstrap.com/**",
	                "https://github.com/twbs/bootstrap/blob/master/LICENSE/**",
	                "../fonts/fontawesome-webfont.eot?v=4.7.0/**",
	                "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/**",
	                "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/**",
	                "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/**",
	                "/js/**",
	                "/images/**",
	                "/admin/show",
	                "/typAnyThing/show",
	                "/typAnyThing2/show",
	                "/aAndnAdminProtal",
	                "/revel/js/**",
	                "/revel/css/**",
	                "/revel/lib/**",
	                "joblistAandN",
	                "joblistAndamanAndNicobarIslands",
	                "joblistAssam",
	                "/joblistBihar",
	                "joblistChhattisgarh",
	                "joblistDelhi",
	                "joblistGujrat",
	                "joblistJharkhand",
	                "joblistKarnataka",
	                "joblistMadhyaPradesh",
	                "joblistMaharashtra",
	                "joblistOdisa",
	                "joblistTe",
	                "joblistTripura",
	                "joblistUttarKhand",
	                "joblistUttarPradesh",
	                "joblistWestBengal",
	                "typAnyThingAandN",
	                "typAnyThingAndamanAndNicobar",
	                "typAnyThingAssam",
	                "typAnyThingBihar",
	                "typAnyThingChhattisgarh",
	                "typAnyThingDelhi",
	                "typAnyThingEdit",
	                "typAnyThingGujrat",
	                "typAnyThingKarnataka",
	                "typAnyThingMadhyaPradesh",
	                "typAnyThingMaharashtra",
	                "typAnyThingOdisa",
	                "typAnyThingTe",
	                "typAnyThingTripura",
	                "typAnyThingUttarKhand",
	                "typAnyThingUttarPradesh",
	                "typAnyThingWestBengal",
	                "/typAnyThingAandN/show",
	                "/typAnyThingAndamanAndNicobar/show",
	                "/typAnyThingAssam/show",
	                "/typAnyThingBihar/show",
	                "/typAnyThingChhattisgarh/show",
	                "/typAnyThingDelhi/show",
	                "/typAnyThingGujrat/show",
	                "/typAnyThingJharKhand/show",
	                "/typAnyThingKarnataka/show",
	                "/typAnyThingMadhyaPradesh/show",
	                "/typAnyThingMaharashtra/show",
	                "/typAnyThingOdisa/show",
	                "/typAnyThingTe/show",
	                "/typAnyThingTripura/show",
	                "/typAnyThingUttarKhand/show",
	                "/typAnyThingUttarPradesh/show",
	                "/typAnyThingWestBengal/show",
	                "/typAnyThingAandN/saveImageDetails",
	                "/typAnyThingAandN/display/{id}",
	                "/deleteAandN/{id}",
	                "/typAnyThing/saveImageDetailsAndamanAndNicobarIslands",
	                "/typAnyThing/displayAndamanAndNicobarIslands/{id}",
	                "/typAnyThing/imageDetailsAndamanAndNicobarIslands",
	                "/typAnyThingAndamanAndNicobarIslands/show",
	                "/editAndamanAndNicobarIslands/{id}",
	                "/deleteAndamanAndNicobarIslands/{id}",
	                "/typAnyThing/saveImageDetails",
	                "/typAnyThing/displayAssam/{id}",
	                "/typAnyThing/imageDetailsAssam",
	                "/typAnyThingAssam/show",
	                "/editAssam/{id}",
	                "/typAnyThingAndamanAndNicobarIslandsJoblist/show",
	                "typAnyThingAandN2",
	                "/joblistAandN",
	                "/bihar/saveImageDetails",
	                "/delhi/saveImageDetails",
	                "/typAnyThingDelhi",
	                "/gujrat/saveImageDetails",
	                "/gujrat/saveImageDetails",
	                "/westBengal/saveImageDetails",
	                "/chhattisgarh/saveImageDetails",
	                "/odisa/saveImageDetails",
	                "/odisa/saveImageDetails",
	                "/te/saveImageDetails",
	                "/maharashtra/saveImageDetails",
	                "/karnataka/saveImageDetails",
	                "/assam/saveImageDetails",
	                "/tripura/saveImageDetails",
	                "/jharkhand/saveImageDetails",
	                "/typAnyThingJharkhand",
	                "/typAnyThingMadhyaPradesh",
	                "/madhyaPradesh/saveImageDetails",
	                "/mp/saveImageDetails",
	                "/up/saveImageDetails",
	                "typAnyThingUttarPradesh",
	                "/uk/saveImageDetails",
	                "/typAnyThingJharKhand",
	                "/deleteGujrat/{id}",
	                "/typAnyThingGujrat/show",
	                "/deleteAndamanAndNicobarIslands/{id}",
	                "/bihar/saveImageDetails",
	                "/typAnyThing/displayBihar/{id}",
	                "/deleteBihar/{id}",
	                "/deleteAandN/{id}",
	                "/typAnyThing/displayAssam/{id}",
	                "/deleteAssam/{id}",
	                "/typAnyThingChhattisgarh/display/{id}",
	                "/deleteChhattisgarh/{id}",
	                "/typAnyThing/imageDetailsChhattisgarh",
	                "/typAnyThingDelhi/display/{id}",
	                "/deleteDelhi/{id}",
	                "/typAnyThingGujrat/display/{id}",
	                "/deleteGujrat/{id}",
	                "/typAnyThingJharkhand/display/{id}",
	                "/deleteJharkhand/{id}",
	                "/typAnyThingJharkhand",
	                "/typAnyThingKarnataka/display/{id}",
	                "/deleteKarnataka/{id}",
	                "/karnataka/saveImageDetails",
	                "/typAnyThingKarnataka/display/{id}",
	                "/deleteKarnataka/{id}",
	                "/typAnyThingMaharashtra/display/{id}",
	                "/deleteMaharashtra/{id}",
	                "/typAnyThingMadhyaPradesh/display/{id}",
	                "/deleteMaharashtra/{id}",
	                "/deleteMadhyaPradesh/{id}",
	                "/typAnyThingOdisa/display/{id}",
	                "/deleteOdisa/{id}",
	                "/typAnyThingTe/display/{id}",
	                "/deleteTe/{id}",
	                "/typAnyThingTripura/display/{id}",
	                "/deleteTripura/{id}",
	                "/typAnyThingUP/display/{id}",
	                "/deleteUP/{id}",
	                "/typAnyThingUK/display/{id}",
	                "/deleteUK/{id}",
	                "/typAnyThingWestBengal/display/{id}",
	                "/deleteWestBengal/{id}",
	                "https://nikhilbharat.co/typAnyThingJharkhand",
	                "/typAnyThingJharkhand",
	                "/typAnyThingJharkhand/show",
	                "/indexVideoUpload",
	                "/upload",
	                "/videos/{title}",
	                "/video/{id}",
	                "/indexVideoooo",
	                "/videos/**",
	                "/videoplay",
	                "/css/**",
	                "lang/messages",
	                "messageSource",
	                "https://twon.onrender.com/",
	                "https://twon.onrender.com/registration",
	                "https://twon.onrender.com/login"
	                )
			.permitAll()
			.requestMatchers(HttpMethod.GET,"/")
			.hasAnyRole("user","admin")
			.requestMatchers(HttpMethod.POST,"/login","/registration","/index","/registration","/new_product","/save")
			.hasAnyRole("user","admin")	
			.and().logout().logoutSuccessUrl("/")
			
			.and().csrf().disable().cors();
		
	//	http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
		
		//http://localhost:8080/new_product
		
		http.securityContext(securityContext->securityContext.requireExplicitSave(true));
		
		return http.build();
		}

}
