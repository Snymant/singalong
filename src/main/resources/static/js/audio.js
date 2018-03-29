/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var RegionsPlugin = window.WaveSurfer.regions;
var regionProgress = 0;
var regions;
var editRegions = false;
var deleteRegion = false;

var wavesurfer = WaveSurfer.create({
    container: '#waveform',
    waveColor: 'violet',
    progressColor: 'purple',
    //splitChannels: true,
    plugins: [
        RegionsPlugin.create()
    ]
});


wavesurfer.load('/audio/bensound-memories.mp3');

wavesurfer.on('seek', function (progress) {
    console.dir(wavesurfer);
    console.log("seeked to " + progress);
});

wavesurfer.on("region-created", function () {
    //wavesurfer.disableDragSelection();
});

//wavesurfer.on('audioprocess', function (time) {
//    //console.dir(wavesurfer);
//    console.log("time is " + wavesurfer.backend.getPlayedPercents())
//});

wavesurfer.on('ready', function () {
    // Enable creating regions by dragging
//    wavesurfer.enableDragSelection({});

    // Add a couple of pre-defined regions
//    var r = ({
//        start: 2, // time in seconds
//        end: 5, // time in seconds
//        color: 'hsla(100, 100%, 30%, 0.1)',
//        content: 'this is a region'
//    });
//    wavesurfer.addRegion(r);
//
//    wavesurfer.addRegion({
//        start: 8,
//        end: 14,
//        color: 'hsla(200, 100%, 30%, 0.1)'
//    });
//
//    wavesurfer.addRegion({
//        start: 28,
//        end: 36,
//        color: 'hsla(400, 100%, 30%, 0.1)'
//    });


    //find all regions
});

wavesurfer.on("pause", function () {
    console.log("audio paused");
    playNextRegion();
});

wavesurfer.on("finish", function () {
    console.log("audio finish");
});

playRegions = function () {
    regionProgress = 0;
    if (wavesurfer.regions) {
        regions = Object.keys(wavesurfer.regions.list);
        playNextRegion();
    }
};

playNextRegion = function () {
    if (regionProgress < regions.length) {
        wavesurfer.regions.list[regions[regionProgress]].play();
    }
    regionProgress++;
};

startEditRegions = function () {
    editRegions = true;
    wavesurfer.enableDragSelection({});
    document.getElementById("editButtons").style.display = "block";
};

stopEditRegions = function () {
    editRegions = false;
    wavesurfer.disableDragSelection();
    document.getElementById("editButtons").style.display = "none";
};


