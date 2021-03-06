<?php
    include ('../../header.php');
?>

    <div class="section section-header">
        <div class="parallax filter">
            <div class="image"
                style="background-image: url('../../assets/img/background/bf1Pic7.jpg')">
            </div>
            <div class="container">
                <div class="content">
                    <div class="title-area">
                        <h1 class="title-modern"></h1>
                        <h2>Frontlines</h2>
                    </div>

                </div>

            </div>
        </div>
    </div>


    <div class="section section-our-clients-freebie">
        <div class="container">
            <div class="title-area">
                <h5 class="subtitle text-gray">PS4 BF1 Tournament</h5>
                <h2>EOO Frontlines 8v8 Season 1</h2>
                <div class="separator separator-danger">♦</div>
            </div>

            <ul class="nav nav-text" role="tablist">
                <li class="active">
                    <a href="#testimonial1" role="tab" data-toggle="tab">
                        <div class="image-clients">
                            <button type="button" class="btn btn-info">Standings</button>
                            <p></p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#testimonial2" role="tab" data-toggle="tab">
                        <div class="image-clients">
                            <button type="button" class="btn btn-info">Schedule</button>
                            <p></p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#testimonial3" role="tab" data-toggle="tab">
                        <div class="image-clients">
                            <button type="button" class="btn btn-info">Rules</button>
                            <p></p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#testimonial4" role="tab" data-toggle="tab">
                        <div class="image-clients">
                            <button type="button" class="btn btn-info">Registration</button>
                            <p></p>
                        </div>
                    </a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="testimonial1">
                    
<?php

require ('../../mysqli_connect.php');

                // Number of records to show per page:
                $display = 30;
                $tourney = 'EOO FL 8v8';

                // Determine how many pages there are...
                if (isset($_GET['p']) && is_numeric($_GET['p'])) { // Already been determined.
                    $pages = $_GET['p'];
                } else { // Need to determine.
                    // Count the number of records:
                    $q = "SELECT COUNT(compete_id) FROM eooFLS1 WHERE tournament='$tourney'";
                    $r = @mysqli_query ($dbc, $q);
                    $row = @mysqli_fetch_array ($r, MYSQLI_NUM);
                    $records = $row[0];
                    // Calculate the number of pages...
                    if ($records > $display) { // More than 1 page.
                        $pages = ceil ($records/$display);
                    } else {
                        $pages = 1;
                    }
                } // End of p IF.

                // Determine where in the database to start returning results...
                if (isset($_GET['s']) && is_numeric($_GET['s'])) {
                    $start = $_GET['s'];
                } else {
                    $start = 0;
                }

                // Determine the sort...
                // Default is by submission date.
                $sort = (isset($_GET['sort'])) ? $_GET['sort'] : 'ds';

                // Determine the sorting order:
                switch ($sort) {
                    default:
                        $order_by = 'points DESC';
                        $sort = 'ds';
                        break;
                }

                // Define the query:
                $q = "SELECT teamname, teamtag, wins, loses, points AS ds, compete_id FROM eooFLS1 ORDER BY $order_by LIMIT $start, $display";
                $r = @mysqli_query ($dbc, $q); // Run the query.

                // Table header:
                echo '<div class="description">
                        <div id="standingDiv">
                            <table id="standingTable">
                                <tr>
                                    <th>Rank</th>
                                    <th>Team</th>
                                    <th>Record</th>
                                    <th>Points</th>
                                </tr>
                ';
                $counter = 0;
                // Fetch and print all the records....
                while ($row = mysqli_fetch_array($r, MYSQLI_ASSOC)) {
                    $counter++;
                        echo '<tr>
                            <td>' . $counter . '</td>
                            <td>' . '[' . $row['teamtag'] . ']' . ' ' . $row['teamname'] . '</td>
                            <td>' . $row['wins'] . ' - ' . $row['loses'] . '</td>
                            <td>' . $row['ds'] . '</td>
                        </tr>
                    ';
                } // End of WHILE loop.

                echo '</table>';
                mysqli_free_result ($r);
                mysqli_close($dbc);

                // Make the links to other pages, if necessary.
                if ($pages > 1) {

                    echo '<br /><p>';
                    $current_page = ($start/$display) + 1;

                    // If it's not the first page, make a Previous button:
                    if ($current_page != 1) {
                        echo '<a href="eooFrontlinesS1.php?s=' . ($start - $display) . '&p=' . $pages . '&sort=' . $sort . '">Previous</a> ';
                    }

                    // Make all the numbered pages:
                    for ($i = 1; $i <= $pages; $i++) {
                        if ($i != $current_page) {
                            echo '<a href="eooFrontlinesS1.php?s=' . (($display * ($i - 1))) . '&p=' . $pages . '&sort=' . $sort . '">' . $i . '</a> ';
                        } else {
                            echo $i . ' ';
                        }
                    } // End of FOR loop.

                    // If its not the last page, make a Next button:
                    if ($current_page != $pages) {
                        echo '<a href="eooFrontlinesS1.php?s=' . ($start + $display) . '&p=' . $pages . '&sort=' . $sort . '">Next</a>';
                    }

                    echo '</p>'; // Close the paragraph.

                } // End of links section.

                ?>

                            </table>
                        </div>
                    </div>
                </div>

                <div class="tab-pane" id="testimonial2">
                    <div class="description">
                        <div id="scheduleDiv">
                            <table id="scheduleTable">
                                <tr>
                                    <th>Week 1</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Team A vs Team B</td>
                                    <td></td>
                                    <td>Feb 2</td>
                                </tr>
                                <tr>
                                    <td>Team C vs Team D</td>
                                    <td></td>
                                    <td>Feb 2</td>
                                </tr>
                                <tr>
                                    <td>Team E vs Team F</td>
                                    <td></td>
                                    <td>Feb 2</td>
                                </tr>
                                <tr>
                                    <td>Team G vs Team H</td>
                                    <td></td>
                                    <td>Feb 2</td>
                                </tr>
                                <tr>
                                    <td>Team I vs Team J</td>
                                    <td></td>
                                    <td>Feb 2</td>
                                </tr>
                                <tr>
                                    <td>Team K vs Team L</td>
                                    <td></td>
                                    <td>Feb 2</td>
                                </tr>
                            </table>
                            <table id="scheduleTable">
                                <tr>
                                    <th>Week 2</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 9</td>
                                </tr>
                            </table>
                            <table id="scheduleTable">
                                <tr>
                                    <th>Week 3</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 16</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 16</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 16</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 16</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 16</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 16</td>
                                </tr>
                            </table>
                            <table id="scheduleTable">
                                <tr>
                                    <th>Week 4</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 23</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 23</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 23</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 23</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 23</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Feb 23</td>
                                </tr>
                            </table>
                            <table id="scheduleTable">
                                <tr>
                                    <th>Week 5</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 2</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 2</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 2</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 2</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 2</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 2</td>
                                </tr>
                            </table>
                            <table id="scheduleTable">
                                <tr>
                                    <th>Week 6</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 9</td>
                                </tr>
                                <tr>
                                    <td>Team vs Team </td>
                                    <td></td>
                                    <td>Mar 9</td>
                                </tr>
                            </table>
                            <table id="scheduleTable">
                                <tr>
                                    <th>Semi-Finals</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Seed 1 vs Seed 4</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Seed 2 vs Seed 3</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
                            <table id="scheduleTable">
                                <tr>
                                    <th>Finals</th>
                                    <th>Results</th>
                                    <th>Match Date</th>
                                </tr>
                                <tr>
                                    <td>Finalist  1 vs Finalist 2</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="testimonial3">
                    <div class="description">
                        <div>
                            <p>This tournament is hosted and managed by EOO. All matches will be livestreamed by an EOO representative. Rules for this tournament will follow <a href="https://esport-battlefield.com/ruleset-bf1-8v8/">ESB guidelines</a>.</p>
                            <p>Points for the tournament standings will be gained as followed:</p>
                                <ul>
                                    <li>Each Flag Cap: 1 Point</li>
                                    <li>Each Bomb Successfully Armed: 3 Points</li>
                                    <li>Each Round Won: 5 Points (Winning in any manner)</li>
                                </ul>
                            </p>
                            <p>The season will consist of 1 match a week, till every team has played eachother. At the end of the regular season, the 4 teams with the highest amount of points will proceed to a single elimination finals bracket.
                            </p>
                            <p>A player may <strong>ONLY</strong> play for 1 team per tournament per season. Each platoon is allowed to register up to 2 teams (during registration please name teams like PlatoonName 1 and PlatoonName 2). Platoons that have 2 competing teams may only use players on one team or the other, the same player cannot play on both teams. Violations of this rule will result in an automatic forfeit in each round that player is used in.
                            </p>
                            <p>The use of a modded controller that allows the player to drop shot, rapid fire a single shot rifle, quickscope, autospot, or perform any other tasks that would otherwise be impossible for a player is prohibited. Gliching and cheating are also prohibited. Violations to these rules will result in suspension of the player as well as an automatic forfeit in each round that player violated the rules in.</p>
                            <p>
                                <h2>1.1 Restrictions (Not Allowed)</h2>
                                <h3>Weapons</h3>
                                <ul>
                                    <li>All Shotguns</li>
                                    <li>Automatico M1918 (All Variants) (Assault)</li>
                                    <li>Martini-Henry Infantry (Recon)</li>
                                    <li>All Paid DLC Weapons</li>
                                </ul>
                                <h3>Grenades</h3>
                                <ul>
                                    <li>Gas Grenades</li>
                                    <li>Incendiary Grenades</li>
                                    <li>Light-Anti Tank</li>
                                    <li>Impact Grenades</li>
                                </ul>
                                <h3>Gadgets</h3>
                                <ul>
                                    <li>Anti-Tank Grenades (Assault)</li>
                                    <li>Flare Gun - Spot (Scout)</li>
                                    <li>Tripwire Bomb: HE / GAS / INC (Scout)</li>
                                </ul>
                                <h3>Vehicles</h3>
                                <ul>
                                    <li>All Behemoth use is banned. Including spawning in one.</li>
                                </ul>
                                <h3>Armor</h3>
                                <ul>
                                    <li>Light Tanks only are allowed (Meaning Heavy Tanks, Landships, and Mobile Artilleries are banned).</li>
                                    <li>You may not have more than 1 Armored Vehicle spawned at any given time.</li>
                                </ul>
                                <h3>Air</h3>
                                <ul>
                                    <li>Air Vehicles are limited to 1 of each type</li>
                                    <li>You may not have more than 1 Air Vehicle spawned at any given time.</li>
                                </ul>
                                <h3>Other Vehicles</h3>
                                <ul>
                                    <li>The horse class and horses are banned. This means you can neither use a horse, nor spawn on one and get off and keep playing.</li>
                                </ul>
                                <h3>Penalties</h3>
                                <ul>
                                    <li>If a team violates a GADGET or VEHICLE restriction, only the map the item was used on will be forfeited and not the entire match.</li>
                                    <li>If a team violates a WEAPONS or GRENADE restriction, a 1 Point Penalty per BANNED Weapon Kill will be applied.
                                        <li>This means that getting a kill with a – banned weapon no longer costs your team the map</li>
                                    </li>
                                    <li>Teams will be required to report and provide proof of any rule infraction(s) at the end of the map in which the infraction occurred. Failure to do so can possibly void any penalty for the opposing team.</li>
                                </ul>
                            </p>
                            <p>
                                <h2>1.2 Maps</h2>
                                <h3>Map Pool</h3>
                                <ul>
                                    <li>Verdun Heights</li>
                                    <li>Fort de Vaux</li>
                                    <li>Soissons</li>
                                    <li>Rupture</li>
                                    <li>Amiens</li>
                                    <li>Argonne Forest</li>
                                </ul>
                            </p>
                            <p>
                                <h2>1.3 Server Settings</h2>
                                <p>Every server MUST be password protected. We recommend that teams change their server password before every match to avoid people keeping track of old passwords and joining as possible spectators. We also recommend having at least one server admin present during your games in case any issues arise.</p>
                                <h3>Weapons</h3>
                                <ul>
                                    <li>MELEE <strong>ON</strong></li>
                                    <li>SHOTGUN <strong>OFF</strong></li>
                                    <li>HANDGUN <strong>ON</strong></li>
                                    <li>EXPLOSIVES <strong>ON</strong></li>
                                    <li>LMG <strong>ON</strong></li>
                                    <li>SMG <strong>ON</strong></li>
                                    <li>SELF-LOADING RIFLES <strong>ON</strong></li>
                                    <li>SINGLE-ACTION RIFLES <strong>ON</strong></li>
                                    <li>CLASS GADGETS <strong>ON</strong></li>
                                    <li>STANDARD ISSUE RIFLES <strong>OFF</strong></li>
                                </ul>
                                <h3>Kits</h3>
                                <ul>
                                    <li>ASSAULT <strong>ON</strong></li>
                                    <li>MEDIC <strong>ON</strong></li>
                                    <li>SUPPORT <strong>ON</strong></li>
                                    <li>SCOUT <strong>ON</strong></li>
                                    <li>ELITE CLASSES <strong>OFF</strong></li>
                                </ul>
                                <h3>Misc</h3>
                                <ul>
                                    <li>KILL CAM <strong>OFF</strong></li>
                                    <li>HUD <strong>ON</strong></li>
                                    <li>FRIENDLY FIRE <strong>ON</strong></li>
                                    <li>REGENERATE HEALTH <strong>ON</strong></li>
                                    <li>3D SPOTTING <strong>OFF</strong></li>
                                    <li>MINIMAP SPOTTING <strong>ON</strong></li>
                                    <li>ALWAYS FOG <strong>OFF</strong></li>
                                    <li>NAMETAGS <strong>ON</strong></li>
                                    <li>VEHICLE 3P CAM <strong>ON</strong></li>
                                    <li>ONLY SQUAD LEADER SPAWN <strong>OFF</strong></li>
                                    <li>BEHEMOTH <strong>OFF</strong></li>
                                    <li>RELOADING FULL MAGS <strong>OFF</strong></li>
                                    <li>MAP VOTING <strong>OFF</strong></li>
                                    <li>LOWER MIN PLAYER COUNT <strong>OFF</strong></li>
                                    <li>AIM ASSIST AUTO ROTATION <strong>OFF</strong></li>
                                    <li>AIM ASSIST SLOW DOWN <strong>ON</strong></li>
                                    <li>LATENCY LOCK <strong>OFF</strong></li>
                                    <li>LENIENT LATENCY <strong>OFF</strong></li>
                                    <li>UNLIMITED MAGAZINES <strong>OFF</strong></li>
                                </ul>
                                <h3>Rules</h3>
                                <ul>
                                    <li>BULLET DAMAGE <strong>100%</strong></li>
                                    <li>TICKET COUNT <strong>100%</strong></li>
                                    <li>RESPAWN TIME <strong>100%</strong></li>
                                    <li>VEHICLE RESPAWN <strong>100%</strong></li>
                                    <li>ROUND TIME LIMIT <strong>0%</strong></li>
                                </ul>
                            </p>
                            <p>
                                <h2>1.4 Scoring</h2>
                                <h3>1.4.1 Map Scoring</h3>
                                <p>Each Map is composed of 2 rounds (sides). The side ends after either the time runs out, or if one team destroys both MCOMs.</p>
                                <p>Your team wins the map by:</p>
                                <ul>
                                    <li>Having obtained the most points overall after the 2 sides are played.</li>
                                </ul>
                                <p>How points are obtained throughout the match:</p>
                                <ul>
                                    <li>Flag Cap: 1 Point</li>
                                    <li>Round Win: 5 Points (Arming both bombs)</li>
                                </ul>
                                <p>At the end of each side, the end of round screen will display how many Flags each team capped.
                                </p>
                                <p>In the event of a Tie at the end of both sides in a BO1 situation, a 10 min extra tie-breaker round will be played.
                                </p>
                                <p>Note: Each Map has 2 factions opposing each other. When playing 2 sides in a map, teams will play Faction A in Side 1 and Faction B in side 2 (or vice-versa).
                                </p>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="testimonial4">
                    <div class="description">
                        <div>
                            <p>

                                 <?php
                                      // If user creates team
                                      if (isset($_POST['saveform']) && $_POST['saveform'] == 'TRUE')
                                      {
                                       require ('../../mysqli_connect.php');

                                       $teamname = mysqli_real_escape_string($dbc,$_POST['teamname']);
                                       $teamtag = mysqli_real_escape_string($dbc, $_POST['teamtag']);
                                       $founder = mysqli_real_escape_string($dbc, $_POST['founder']);;
                                       $tournament = 'EOO FL 8v8';
                                       $season = 'S1';
                                       $wins = '0';
                                       $loses = '0';
                                       $points = '0';

                                        $q = "INSERT INTO eooFLS1 (teamname, registration_date, teamtag, founder, tournament, season, wins, loses, points)" . "VALUES ('$teamname',NOW(),'$teamtag','$founder', '$tournament', '$season' , '$wins', '$loses', '$points')";
                                         //  echo $q."<br>"; // debug echo - comment out of finished version

                                        $r = @mysqli_query($dbc, $q);

                                        $q = "INSERT INTO teamcompetelist (teamname, registration_date, teamtag, founder, tournament, season, wins, loses, points)" . "VALUES ('$teamname',NOW(),'$teamtag','$founder', '$tournament', '$season' , '$wins', '$loses', '$points')";
                                           //  echo $q."<br>"; // debug echo - comment out of finished version

                                          $r = @mysqli_query($dbc, $q);

                                        if ($r) {

                                ?>

                                        <table style="background-color:#31B404;" width="100%" align="center">
                                            <tr>
                                                <td><font color="#FFFFFF"><center>Your team has been registered!</center></font></td>
                                            </tr>
                                        </table>
                                <?php
                                        }
                                        }
                                ?>
                                    <div>
                                        <p>

                                            <form action="" method="POST">
                                                <div class="description">
                                                    <div id="registerDiv">
                                                        <table id="registerTable">
                                                            <tr>
                                                                <td id="rightjustified">Team Tag: </td>
                                                                <td id="leftjustified"> [ <input style="color: #000000;" type="text" name="teamtag" size="4" maxlength="4" /> ]</td>
                                                            </tr>
                                                            <tr>
                                                                <td id="rightjustified">Team Name: </td>
                                                                <td id="leftjustified"> <input style="color: #000000;" type="text" name="teamname" size="15" maxlength="60"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td id="rightjustified">Your PSN: </td>
                                                                <td id="leftjustified"> <input style="color: #000000;" type="text" name="founder" size="15" maxlength="60"/></td>
                                                            </tr>
                                                        </table>
                                                        <br>
                                                        <p>
                                                        <input type="hidden" name="saveform" value="FALSE" />
                                                        <input type="button" name="save" value="Register" onclick="document.forms[0].saveform.value='TRUE';document.forms[0].submit();" />
                                                        </p>
                                                            
                                                    </div>
                                                </div>
                                            </form>
                                        </p>
                                    </div>

                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<?php
    include ('../../footer.php');
?>