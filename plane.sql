create table plane (
    id_plane int not null auto_increment,
    seats_available int not null,
    total_seats int not null,
    model varchar(255) not null,
    constraint id_plane_fk primary key (id_plane)
)