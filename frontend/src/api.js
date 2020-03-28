import Axios from "axios";

const ajax = Axios.create({
  baseURL: `${location.host}/api`, //"http://localhost:8080/api",
  timeout: 60 * 1000
});

class Api {
  getAll() {
    return ajax.get("employees");
  }

  get(id) {
    return ajax.get(`/employees/${id}`);
  }

  create(data) {
    return ajax.post("/employees", data);
  }

  update(id, data) {
    return ajax.put(`/employees/${id}`, data);
  }

  delete(id) {
    return ajax.delete(`/employees/${id}`);
  }

  deleteAll() {
    return ajax.delete(`/employees`);
  }

  findByName(name) {
    return ajax.get(`/employees?name=${name}`);
  }

  find(params) {
    return ajax.get(`/employees`, {
      params
    });
  }
}

export default new Api();
