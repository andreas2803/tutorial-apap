//package apap.tutorial.cineplux.service;
//
//import apap.tutorial.cineplux.model.UserModel;
//import apap.tutorial.cineplux.repository.UserDb;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService ;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserDb userDb;
//    private UserModel UserModeluser;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserModeluser = userDb.findByUsername(username);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(newSimpleGrantedAuthority(user.getRole().getRole()));
//        return new User(user.getUsername(), user.getpassword(), grantedAuthorities);
//    }
//}
