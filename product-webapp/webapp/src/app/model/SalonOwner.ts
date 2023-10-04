import { Salon } from './Salon';

export class SalonOwner {
  ownerId?: String;
  email?: String;
  name?: String;
  mobileNo?: String;
  referalCode?: String;
  addr?: String;
  dob?: String;
  salonList?: Array<Salon>;
  aprovedbyadmin?: boolean;
  price?: String;

}
