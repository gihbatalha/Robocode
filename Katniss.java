package THG;
import robocode.*;
import java.awt.Color;
/**
 * Katniss - a robot by (Giovanna Batalha)
 */
public class Katniss extends AdvancedRobot
{
double vez;
double erros;
double acertos;
double fuiAcertado;
boolean atacar;

	public void run() {
		setColors(Color.black,Color.black,Color.red); // body,gun,radar
			
		while(true) {
			ahead(100);
			turnRight(360);
			back(100);
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
	
	if (acertos==1){
	fire(3);
	acertos=0;
	}
	
		
	if (atacar ==true){
	stop();
	vez=0;
	while(vez<3){
	fire(3);
	vez+=1;
	}
	
	setTurnGunRight(getHeading() - getRadarHeading() + e.getBearing());
	setTurnRight(getHeading() - getRadarHeading() + e.getBearing());
	
	double forca = Math.min(1000 / e.getDistance(), 3);
	setAhead(100);
	fire(forca);

	vez = 0;
	
	if (getX() <= 100 || getX() >= getBattleFieldWidth() - 100 ||
		getY() <= 100 || getY() >= getBattleFieldHeight() - 100){
	ahead(100);
	}

	}
	
//	if (erros>=5){
	//setTurnGunRight(getHeading() - getRadarHeading() + e.getBearing());
	//setTurnRight(getHeading() - getRadarHeading() + e.getBearing());
	//setAhead(100);
	//erros=0;
	//setTurnLeft(getHeading() - getRadarHeading() + e.getBearing());
	//turnRight(360);
	//}
	scan();

			
	}
	public void onHitByBullet(HitByBulletEvent e) {
	fuiAcertado +=1;
	
	if (fuiAcertado>=3)
	atacar = true;		
	}
	
	public void onHitRobot(HitRobotEvent e){
	
	while (acertos==1)
	fire(3);
	}
	
	public void onHitWall(HitWallEvent e) {
		turnRight(90);
		ahead(150);		
	}
	
	public void onBulletMissed(BulletMissedEvent e){
	erros += 1;
	acertos=0;
	} 	
	
	public void onBulletHit(BulletHitEvent e){
	acertos=1;
	} 
}
								