import requester from "./Requester"

class KeywordService {

    static BASE_URL = "http://localhost:8080/keyword"


    findAll(){
        return requester.get(`${KeywordService.BASE_URL}/findAll`)
    }

    create(fol: any){
        return requester.post(`${KeywordService.BASE_URL}/create`, fol)
    }
}

const keywordService = new KeywordService();
export default keywordService;