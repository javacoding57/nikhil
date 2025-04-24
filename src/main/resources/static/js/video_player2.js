function changeVid(clicked_id)
                    {

                        var newVid = "javatechie.mp4";

                        if(clicked_id === 'vid1'){
                            newVid = 'videos/Back.in.Action.2025.1080p.WEBRip.10Bit.DDP5.1.x265-Asiimov.mkv';

                        }
                         if(clicked_id === 'vid2'){
                            newVid = "videos/SkyForce2025.mp4";
                        }
                         if(clicked_id === 'vid3'){
                            newVid = "/videos/javatechie.mp4";
                        }
                         if(clicked_id === 'vid4'){
                            newVid = "/videos/javatechie.mp4";
                        }
                         if(clicked_id === 'vid5'){
                            newVid = " ";
                        }
                         if(clicked_id === 'vid6'){
                            newVid = " ";
                        }

                        document.getElementById('player1').src = newVid;
                    }
                    
/*                    
var $allVideos = $("iframe[src^='//player.vimeo.com'], iframe[src^='//www.youtube.com']"); */

/*
var vid1 = document.getElementById('vid1');

function toggleMute(){
  vid1.muted = !vid1.muted;
}

*/
