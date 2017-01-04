import {Session} from "../session/session";
/**
 * Created by bondarm on 02.01.17.
 */
export class Movie{
    id: number;
    name: string;
    description: string;
    starting: Date;
    sessions: Session[];
    genre: string;
    duration: number;
}
