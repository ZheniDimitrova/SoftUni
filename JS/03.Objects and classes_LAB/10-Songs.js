function songs(array) {

    class Song{
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }
    let songs = [];
    let countSongs = Number(array.shift());
    let givenSongType = array.pop();

    for (let index = 0; index < countSongs; index++) {
        let data = array[index].split("_");
        let typeList = data[0];
        let name = data[1];
        let time = data[2];
        let song = new Song(typeList, name, time);
        songs.push(song);
    }

    if (givenSongType === "all") {
        songs.forEach(e => console.log(e.name));

    } else {
        let filteredSongs = songs.filter(s => s.typeList === givenSongType);
        filteredSongs.forEach(e => console.log(e.name));

    }
}

songs([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']);

songs([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all'])