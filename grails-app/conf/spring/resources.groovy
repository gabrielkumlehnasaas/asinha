import com.asinha.domain.CustomUserDetailsService
import com.asinha.utils.UserPasswordEncoderListener

beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userDetailsService(CustomUserDetailsService)
}
