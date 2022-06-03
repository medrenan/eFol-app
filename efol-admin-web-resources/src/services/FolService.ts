import requester from "./Requester"

class FolService {

    static BASE_URL = "http://localhost:8080/fol"


    findAll(){
        return requester.get(`${FolService.BASE_URL}/findAll`)
    }

    create(fol: any){
        return requester.post(`${FolService.BASE_URL}/create`, fol)
    }
}

const folService = new FolService();
export default folService;