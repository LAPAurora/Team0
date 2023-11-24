import Vue from 'vue'
import App from './App'

import love from './pages/love/index.vue'
Vue.component('love',love)
import my from './pages/my/index.vue'
Vue.component('my',my)
import cuCustom from './colorui/components/cu-custom.vue'
Vue.component('cu-custom',cuCustom)
import api from "./utils/api";
Vue.prototype.$api = api;
import Fly from './utils/fly'
Vue.prototype.$req = new Fly;
Vue.config.productionTip = false
//Vuex
import store from './store'
Vue.prototype.$store = store
 
//请求加载组件
import requestLoading from './components/loading.vue';
//组件挂载到全局，方便每个页面使用
Vue.component('request-loading', requestLoading);
 
//挂载全局显示/隐藏请求加载动画
function showLoading(){
	store.commit('request_show_loading');
}
function hideLoading(){
	store.commit('request_hide_loading');
}
Vue.prototype.$showLoading = showLoading; //全局显示动画可以 this.$showLoading();
Vue.prototype.$hideLoading = hideLoading; //全局隐藏动画可以 this.$hideLoading();
Vue.prototype.$remove = function(arr,val) { 
		var index = arr.indexOf(val); 
		if (index > -1) { 
		arr.splice(index, 1); 
		} 
		};
Vue.prototype.$encrypt = function(num) { 
		phone= "" + num;
		var phone=phone.substr(0, 4) + '****' + phone.substr(15,19);   
		return phone
		};
Vue.filter("formatDate",(num)=>{
			let number = num +"";
						number = number.replace(/\,/g, "");
						if(isNaN(number) || number == "")return "";
						number = Math.round(number * 100) / 100;
					    if (number < 0)
					        return '-' + outputdollars(Math.floor(Math.abs(number) - 0) + '') + outputcents(Math.abs(number) - 0);
					    else
					        return outputdollars(Math.floor(number - 0) + '') + outputcents(number - 0);
							
							function outputdollars(number) {
							    if (number.length <= 3)
							        return (number == '' ? '0' : number);
							    else {
							        var mod = number.length % 3;
							        var output = (mod == 0 ? '' : (number.substring(0, mod)));
							        for (let i = 0; i < Math.floor(number.length / 3); i++) {
							            if ((mod == 0) && (i == 0))
							                output += number.substring(mod + 3 * i, mod + 3 * i + 3);
							            else
							                output += ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
							        }
							        return (output);
							    }
							}
							function outputcents(amount) {
							    amount = Math.round(((amount) - Math.floor(amount)) * 100);
							    return (amount < 10 ? '.0' + amount : '.' + amount);
			}
		})
Vue.prototype.$toThousands = function(num) { 
		let number = num +"";
			number = number.replace(/\,/g, "");
			if(isNaN(number) || number == "")return "";
			number = Math.round(number * 100) / 100;
		    if (number < 0)
		        return '-' + outputdollars(Math.floor(Math.abs(number) - 0) + '') + outputcents(Math.abs(number) - 0);
		    else
		        return outputdollars(Math.floor(number - 0) + '') + outputcents(number - 0);
				
				function outputdollars(number) {
				    if (number.length <= 3)
				        return (number == '' ? '0' : number);
				    else {
				        var mod = number.length % 3;
				        var output = (mod == 0 ? '' : (number.substring(0, mod)));
				        for (let i = 0; i < Math.floor(number.length / 3); i++) {
				            if ((mod == 0) && (i == 0))
				                output += number.substring(mod + 3 * i, mod + 3 * i + 3);
				            else
				                output += ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
				        }
				        return (output);
				    }
				}
				function outputcents(amount) {
				    amount = Math.round(((amount) - Math.floor(amount)) * 100);
				    return (amount < 10 ? '.0' + amount : '.' + amount);
}
		};
App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()

 



