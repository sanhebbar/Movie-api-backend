package com.movie_app.service;

import com.movie_app.entity.Movie;
import com.movie_app.entity.Review;
import com.movie_app.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepo.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is("imdbId"))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return  review;
    }
}
