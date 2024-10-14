package Model;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.time.Duration;

public class TimeManager {
    private static final double RATE_PER_HOUR = 10.0; // Giá tiền mỗi giờ
    private static int sessionCounter = 0; 
    private int sessionId;
    private LocalDateTime sessionStartTime;
    private LocalDateTime sessionEndTime;

    public TimeManager() {
        this.sessionId = ++sessionCounter;
    }

    public void startSession() {
        sessionStartTime = LocalDateTime.now();
        System.out.println("Session ID: " + sessionId + " started at: " + sessionStartTime);
    }

    public void endSession() {
        sessionEndTime = LocalDateTime.now();
        System.out.println("Session ID: " + sessionId + " ended at: " + sessionEndTime);
    }

    public long getSessionDurationInMinutes() {
        if (sessionStartTime != null && sessionEndTime != null) {
            return Duration.between(sessionStartTime, sessionEndTime).toMinutes();
        }
        return 0;
    }

    public double calculateSessionCost() {
        long durationInMinutes = getSessionDurationInMinutes();
        double cost = (durationInMinutes / 60.0) * RATE_PER_HOUR;
        System.out.println("Session ID: " + sessionId + " cost: " + cost + " VND");
        return cost;
    }
}
