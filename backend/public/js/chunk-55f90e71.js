(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-55f90e71"],{4611:function(e,t,a){},"4ef0":function(e,t,a){"use strict";var n=a("4611"),s=a.n(n);s.a},"6ce5":function(e,t,a){"use strict";var n=a("d2e8"),s=a.n(n);s.a},"9dd5":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"employee-search"},[a("search-form",{on:{searchEnd:e.onSearchEnd}}),a("div",{staticClass:"flex justify-center mt-6"},[a("transition",{attrs:{name:"slide-fade",mode:"out-in"}},[e.results?a("div",{staticClass:"employee-search_div"},[a("table",{staticClass:"employee-search__table"},[a("thead",[a("tr",e._l(e.headers,(function(t){return a("th",{key:t},[e._v(e._s(t))])})),0)]),e._l(e.results,(function(t){return a("tr",{key:t.id},e._l(t,(function(t,n){return a("td",{key:n},[e._v(" "+e._s(e._f("format")(t,n))+" ")])})),0)}))],2)]):e._e()])],1)],1)},s=[],r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("form",{staticClass:"search-form",on:{submit:function(t){return t.preventDefault(),e.search(t)}}},[a("div",[a("label",[e._v("Name")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.name,expression:"name"}],attrs:{name:"name",type:"text",autocomplete:"off"},domProps:{value:e.name},on:{input:function(t){t.target.composing||(e.name=t.target.value)}}})]),a("div",[a("label",[e._v("Start Date")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.startDate,expression:"startDate"}],attrs:{name:"startDate",type:"date"},domProps:{value:e.startDate},on:{input:function(t){t.target.composing||(e.startDate=t.target.value)}}})]),a("div",[a("label",[e._v("End Date")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.endDate,expression:"endDate"}],attrs:{name:"endDate",type:"date"},domProps:{value:e.endDate},on:{input:function(t){t.target.composing||(e.endDate=t.target.value)}}})]),a("div",[a("button",{staticClass:"search-form__button"},[e.loading?a("spinner"):a("span",[e._v("Search")])],1)])])},i=[],o=a("d722"),l=a("2375"),u={name:"search-form",components:{Spinner:l["a"]},data(){return{loading:!1,name:"",startDate:"",endDate:""}},computed:{axiosParams(){const e=new URLSearchParams;return this.name&&e.append("name",this.name),this.startDate&&e.append("start",this.startDate),this.endDate&&e.append("end",this.endDate),e}},methods:{search(){this.loading||(this.$emit("searchEnd",!1),this.loading=!0,o["a"].find(this.axiosParams).then(e=>{this.$emit("searchEnd",e.data),console.log(e.data)}).catch(e=>{console.log("Connection failed: "+e)}).finally(()=>{this.loading=!1}))}}},c=u,d=(a("4ef0"),a("2877")),m=Object(d["a"])(c,r,i,!1,null,null,null),p=m.exports;const h=e=>e.replace(/([A-Z])/g,e=>` ${e}`).replace(/^./,e=>e.toUpperCase());var f={name:"employee-search",components:{SearchForm:p},data(){return{results:null}},computed:{headers(){if(this.results&&this.results.length){const e=Object.keys(this.results[0]).map(e=>h(e));return e}return[]}},methods:{onSearchEnd(e){this.results=e}},filters:{format:function(e,t){if(!e)return"";if("startDate"===t||"endDate"===t){let t=new Date(Date.parse(e)).toUTCString();return t.substring(0,t.length-12)}if("dateOfBirth"===t){let t=new Date(Date.parse(e)),a=t.getFullYear(),n=new Date,s=n.getFullYear();return s-a}return e}}},v=f,D=(a("6ce5"),Object(d["a"])(v,n,s,!1,null,null,null));t["default"]=D.exports},d2e8:function(e,t,a){}}]);