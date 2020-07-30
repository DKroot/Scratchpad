import Vue from 'vue';
import axios, { AxiosPromise } from 'axios';

export default class LoginService {
  public openLogin(instance: Vue): void {
    instance.$emit('bv::show::modal', 'login-page');
  }

  public logout(): AxiosPromise<any> {
    return axios.post('api/logout');
  }
}
