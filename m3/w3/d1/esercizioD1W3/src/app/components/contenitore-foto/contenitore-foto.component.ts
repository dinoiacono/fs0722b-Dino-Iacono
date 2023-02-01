import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { Photo } from 'src/app/photo.interface';
import { PhotoService } from 'src/app/photo.service';

@Component({
  selector: 'app-contenitore-foto',
  templateUrl: './contenitore-foto.component.html',
  styleUrls: ['./contenitore-foto.component.scss']
})
export class ContenitoreFotoComponent implements OnInit {

  photo: Photo[] =[];

  constructor(private photoSrv:PhotoService) { }

  ngOnInit(): void {
    console.log(this.photoSrv.getphoto().pipe(map(ris=>ris)))

  }

}
