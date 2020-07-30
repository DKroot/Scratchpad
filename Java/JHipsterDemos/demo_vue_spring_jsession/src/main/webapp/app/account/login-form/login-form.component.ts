import axios from 'axios';
import Component from 'vue-class-component';
import { Vue, Inject } from 'vue-property-decorator';
import AccountService from '@/account/account.service';
@Component({
  watch: {
    $route() {
      this.$root.$emit('bv::hide::modal', 'login-page');
    },
  },
})
export default class LoginForm extends Vue {
  @Inject('accountService')
  private accountService: () => AccountService;
  public authenticationError = null;
  public login = null;
  public password = null;
  public rememberMe: boolean = null;

  public doLogin(): void {
    const data =
      'username=' +
      encodeURIComponent(this.login) +
      '&password=' +
      encodeURIComponent(this.password) +
      '&remember-me=' +
      this.rememberMe +
      '&submit=Login';
    axios
      .post('api/authentication', data, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
      })
      .then(() => {
        this.authenticationError = false;
        this.$root.$emit('bv::hide::modal', 'login-page');
        this.accountService().retrieveAccount();
      })
      .catch(() => {
        this.authenticationError = true;
      });
  }
}
