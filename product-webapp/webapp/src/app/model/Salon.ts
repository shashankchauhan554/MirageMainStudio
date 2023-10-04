import { Category } from "./Category";

export class Salon {
     salonId ?: string;
     salonName ?: string;
     salonAddress ?: string;
     referalCode ?: string;
     gstNumber ?: string;
     location ?: string ;
     availability ?: string;
     acNonAc ?:boolean;
     NearbyTransportation  ?: string;
     wifi?:boolean;
     maintanance?:boolean;
     price ?: number ;
     categoryList ?: Array<Category>;

}
