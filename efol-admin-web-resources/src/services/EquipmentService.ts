import requester from "./Requester"

class EquipmentService {

    static BASE_URL = "http://localhost:8080/equipment"


    findAll(){
        return requester.get(`${EquipmentService.BASE_URL}/findAll`)
    }

    create(equipment: any){
        return requester.post(`${EquipmentService.BASE_URL}/create`, equipment)
    }
}

const equimentService = new EquipmentService();
export default equimentService;