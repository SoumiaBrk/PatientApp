package fr.soumiabrk.patientapp.response;

import java.util.List;

public class ApiResponse<T> {
    public final int count;
    public final String next;
    public final String previous;
    public final List<T> result;

    public ApiResponse(int count, String next, String previous, List<T> result) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.result = result;
    }
}
