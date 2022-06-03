import $ from 'jquery';

class Requester {

    static GET_OPTIONS = {
        headers: {
            'Accecpt': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        dataType: 'json'
    }

    static POST_OPTIONS = {
        headers: {
            'Accecpt': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'POST',
        dataType: 'json'
    }

    ajaxToPromise(options: any): Promise<any>{
        return new Promise(function (resolve, reject) {
            $.ajax(options).done(resolve).fail(reject);
        }).catch((err) => {
            return Promise.reject(err.responseJSON);
        });
    }

    get(url: string) {
        return this.ajaxToPromise(Object.assign({}, Requester.GET_OPTIONS, {url: url}));
    }

    post(url: string, data: any){
        return this.ajaxToPromise(Object.assign({}, Requester.POST_OPTIONS,  {url: url, data: JSON.stringify(data)}));
    }
}

const requester = new Requester();
export default requester;